/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.webservices.mobile.commons;

/**
 *
 * @author breno.melo
 */
import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

public class Compactador {

    static final int TAMANHO_BUFFER = 2048; // 2kb

    // ------------------------------------------------ Metodos publicos
    public void compactar(String arqSaida, String arqui) {
        int i, cont;
        // Contadores.

        byte[] dados = new byte[TAMANHO_BUFFER];
      // Este array recebera os bytes lidos do arquivo a ser compactado.
        // Veja que TAMANHO_BUFFER foi declarado como uma constante inteira de valor 2048, logo, o arquivo
        // sera lido de 2 em 2 KB. 

        //Recebera a lista dos arquivos a serem compactados.
        File f = null;
        //f nos dara informações sobre a pasta (entrada) em que se encontra a classe.
        BufferedInputStream origem = null;
        FileInputStream streamDeEntrada = null;
        FileOutputStream destino = null;
        //Streams de entrada e saída. (Vide documentaçao do pacote java.io)

        ZipOutputStream saida = null;
        //saida sera usada para gravar nossos dados de forma comprimida.

        ZipEntry entry = null;
        //Cada entrada do nosso arquivo ZIP
        String[] arquivos;
        try {
            destino = new FileOutputStream(arqSaida);
            saida = new ZipOutputStream(new BufferedOutputStream(destino));
            f = new File(arqui); // Todos os arquivos da pasta onde a classe esta
            arquivos = f.list();

            for (i = 0; i < arquivos.length; i++) {
                File arquivo = new File(f.getPath() + File.separator + arquivos[i]);

                if (arquivo.isFile() && !(getExten(arquivo.toString())).equals(".zip")) {
                   // System.out.println("Compactando: " + arquivos[i]);

                    streamDeEntrada = new FileInputStream(arquivo);
                    origem = new BufferedInputStream(streamDeEntrada, TAMANHO_BUFFER);
                    entry = new ZipEntry(arquivos[i]);
                    saida.putNextEntry(entry);

                    while ((cont = origem.read(dados, 0, TAMANHO_BUFFER)) != -1) {
                        saida.write(dados, 0, cont);
                    }

                    streamDeEntrada.close();
                    if (!(getExten(arquivo.toString())).equals(".xml")) {
                        arquivo.delete();
                    }
                    origem.close();
                }
            }

            saida.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//fim compactar()

    public String getExten(String str) {

        int contador = 0;
        String resultado = null;
        for (int i = str.length(); i > contador;) {
            i--;
            if (str.substring(i, i + 1).equals(".")) {
                resultado = str.substring(i);
                break;
            }
        }
        return resultado;
    }

    public void unzip(String arquivoZip, String destino) throws IOException {
        File zipFile = new File(arquivoZip);
        File dir = new File(destino);
        ZipFile zip = null;

        File arquivo = null;

        InputStream is = null;

        OutputStream os = null;

        byte[] buffer = new byte[1024];

        try {
            if (!dir.exists()) {
                dir.mkdirs();
            }
            if (!dir.exists() || !dir.isDirectory()) {

                throw new IOException("O diretorio " + dir.getName()
                        + " nao e um diretorio valido");

            }

            zip = new ZipFile(zipFile);

            Enumeration e = zip.entries();

            while (e.hasMoreElements()) {
                ZipEntry entrada = (ZipEntry) e.nextElement();
                arquivo = new File(dir, entrada.getName());
                if (entrada.isDirectory() && !arquivo.exists()) {
                    arquivo.mkdirs();
                    continue;
                }
                // se a estrutura de diretorios nao existe, cria
                if (!arquivo.getParentFile().exists()) {
                    arquivo.getParentFile().mkdirs();
                }
                try {
                    // lê o arquivo do zip e grava em disco
                    is = zip.getInputStream(entrada);
                    os = new FileOutputStream(arquivo);
                    int bytesLidos = 0;
                    if (is == null) {
                        throw new ZipException("Erro ao ler a entrada do zip: "
                                + entrada.getName());
                    }
                    while ((bytesLidos = is.read(buffer)) > 0) {
                        os.write(buffer, 0, bytesLidos);
                    }
                } finally {
                    if (is != null) {
                        try {
                            is.close();
                        } catch (Exception ex) {
                        }
                    }
                    if (os != null) {
                        try {
                            os.close();
                        } catch (Exception ex) {
                        }
                    }
                }
            }

        } finally {

            if (zip != null) {
                try {
                    zip.close();
                } catch (Exception e) {
                }
            }
        }
    }

    public void criaDiretorio(String novoDiretorio) {
        String nomeDiretorio = null;
        String separador = java.io.File.separator;
        try {
            nomeDiretorio = novoDiretorio;
            if (!new File(nomeDiretorio).exists()) { // Verifica se o diretorio existe.   
                (new File(nomeDiretorio)).mkdir();   // Cria o diretorio   
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
  public void unZip(String diretorio, final File file) {
        //if (file.getName().endsWith(".zip")) {
        String fileName = "";
        try (ZipFile zipFile = new ZipFile(file.getPath())) {
            final Enumeration entries = zipFile.entries();

            //Descompacta os arquivos da pasta e deleta o zip
            while (entries.hasMoreElements()) {
                final ZipEntry entry = (ZipEntry) entries.nextElement();

                if (entry.getName().endsWith(".xml")) {
                    fileName = entry.getName();
               //     log.info("Lendo o arquivo " + entry.getName() + "...");
                    final OutputStream outStream;
                    final File newFile = new File(diretorio + File.separator + entry.getName());

                    try (final InputStream inStream = zipFile.getInputStream(entry)) {
                        outStream = new BufferedOutputStream(new FileOutputStream(newFile));
                        final byte[] buffer = new byte[1024];
                        int len;
                        while ((len = inStream.read(buffer)) >= 0) {
                            outStream.write(buffer, 0, len);
                        }
                    }
                    outStream.close();
                    break;
                }
            }
        } catch (Exception ex) {
           // log.error("Erro na execu��o do m�todo unZip(). Nome do arquivo : " + fileName, ex);
        }
    }
   public String unZipManifest(String diretorio, final File file) {
        //if (file.getName().endsWith(".zip")) {
        String fileName = "";
        String arquivoName = "";
        String ext = "";
        try (ZipFile zipFile = new ZipFile(file.getPath())) {
            final Enumeration entries = zipFile.entries();

            //Descompacta os arquivos da pasta e deleta o zip
            while (entries.hasMoreElements()) {
                final ZipEntry entry = (ZipEntry) entries.nextElement();
            
                if (entry.getName().contains("AndroidManifest.xml")) {
                    fileName = entry.getName();
               //     log.info("Lendo o arquivo " + entry.getName() + "...");
                    final OutputStream outStream;
                    File fil = new File(diretorio);
                    arquivoName = fil.getParent() + File.separator + entry.getName();
                    final File newFile = new File(arquivoName);
                    
                    try (final InputStream inStream = zipFile.getInputStream(entry)) {
                        outStream = new BufferedOutputStream(new FileOutputStream(newFile));
                        final byte[] buffer = new byte[1024];
                        int len;
                        while ((len = inStream.read(buffer)) >= 0) {
                            outStream.write(buffer, 0, len);
                        }
                    }
                    outStream.close();
                    break;
                }
            }
        } catch (Exception ex) {
            return null;
           // log.error("Erro na execu��o do m�todo unZip(). Nome do arquivo : " + fileName, ex);
        }
        return arquivoName;
    }
   
  
}//Compactador.class

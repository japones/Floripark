package br.com.floripark.financeiro.service.impl;

import br.com.floripark.financeiro.dao.DaoFactory;
import br.com.floripark.financeiro.model.Banco;
import br.com.floripark.financeiro.model.Empresa;
import br.com.floripark.financeiro.model.RetornoBancario;
import br.com.floripark.financeiro.model.Servico;
import br.com.floripark.financeiro.model.Usuario;
import br.com.floripark.financeiro.service.IRetornoBancarioService;
import br.com.floripark.financeiro.service.ServiceFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class RetornoBancarioService implements IRetornoBancarioService {

    private RetornoBancario retorno;
    private Date dataInclusao;
    private Date dataAlteracao;

    @Override
    public RetornoBancario inserirRetorno(Servico servico, Empresa empresa, Banco banco, Date dataPagamento, File arquivo, String linha, Usuario usuario) throws Exception {
        dataInclusao = new Date();
        retorno = new RetornoBancario();

        File file = arquivo;
        byte[] bFile = new byte[(int) file.length()];

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
        }

        retorno.setServico(servico);
        retorno.setEmpresa(empresa);
        retorno.setBanco(banco);
        retorno.setDatapagamento(dataPagamento);
        retorno.setArquivo(bFile);
        retorno.setDatainclusao(dataInclusao);
        retorno.setUsuarioinclusao(usuario);
        retorno.setLinha(linha);
        return DaoFactory.getRetornoBancarioDao().inserirRetorno(retorno);
    }

    @Override
    public void excluirRetorno(Integer id) throws Exception {
        DaoFactory.getRetornoBancarioDao().excluirRetorno(pesquisarRetorno(id));
    }

    @Override
    public void alterarRetorno(Integer id, Servico servico, Empresa empresa, Banco banco, Date dataPagamento, File arquivo, Usuario usuario, Date dataInclusao, Usuario usuarioInclusao) throws Exception {
        dataAlteracao = new Date();
        retorno = new RetornoBancario();

        File file = new File(arquivo.getPath());
        byte[] bFile = new byte[(int) file.length()];

        try (FileInputStream fis = new FileInputStream(file)) {
            fis.read(bFile);
        }

        retorno.setId(id);
        retorno.setServico(servico);
        retorno.setEmpresa(empresa);
        retorno.setBanco(banco);
        retorno.setDatapagamento(dataPagamento);
        retorno.setArquivo(bFile);
        retorno.setUsuarioalteracao(usuario);
        retorno.setDataalteracao(dataAlteracao);
        retorno.setUsuarioinclusao(usuarioInclusao);
        retorno.setDatainclusao(dataInclusao);

        DaoFactory.getRetornoBancarioDao().alterarRetorno(retorno);
    }

    @Override
    public RetornoBancario pesquisarRetorno(Integer id) throws Exception {
        return DaoFactory.getRetornoBancarioDao().pesquisarRetorno(id);
    }

    @Override
    public ArrayList<RetornoBancario> pesquisarRetorno() throws Exception {
        return DaoFactory.getRetornoBancarioDao().pesquisarRetorno();
    }

    @Override
    public Boolean importarRetorno(File arquivo, Usuario usuario) throws Exception {
        Date dataInc = new Date();

        FileReader frTemp = new FileReader(arquivo.getPath()); // Local do Arquivo  
        BufferedReader brTemp = new BufferedReader(frTemp);        // Alterando da variável fr para br  
        // PROCESSO PARA POPULAR A TABELA TEMPORARIA
        String s = "";
        while ((s = brTemp.readLine()) != null) {
            ServiceFactory.getTemporarioService().inserirTemporario(s);
        }

        // OBTENÇÃO DOS DADOS PARA INSERIR NA TABELA RETORNO BANCARIO
        // CAPTURA DO SERVIÇO
        FileReader frServico = new FileReader(arquivo.getPath());
        BufferedReader brServico = new BufferedReader(frServico);
        Character sigla = ' ';
        while (sigla == ' ') {
            String var = brServico.readLine();
            if ("3".equals(var.substring(7, 8))) {
                sigla = var.charAt(13);
            }
        }
        Servico servico = ServiceFactory.getServicoService().pesquisaServico(sigla);

        // CAPTURA DO BANCO
        FileReader frBanco = new FileReader(arquivo.getPath());
        BufferedReader brBanco = new BufferedReader(frBanco);
        String sBanco = " ";
        while (" ".equals(sBanco)) {
            String var = brBanco.readLine();
            sBanco = var.substring(0, 3);
        }
        Integer bco = Integer.valueOf(sBanco);
        Banco banco = ServiceFactory.getBancoService().pesquisarBanco(bco);

        // CAPTURA EMPRESA
        FileReader frEmpresa = new FileReader(arquivo.getPath());
        BufferedReader brEmpresa = new BufferedReader(frEmpresa);
        String empresa = " ";
        while (" ".equals(empresa)) {
            String var = brEmpresa.readLine();
            empresa = var.substring(72, 101);
        }
        String trim = empresa.trim();
        Empresa emp = ServiceFactory.getEmpresaService().pesquisarEmpresa(trim);

        // CAPTURA DATA PAGAMENTO
        FileReader frData = new FileReader(arquivo.getPath());
        BufferedReader brData = new BufferedReader(frData);
        String sData = " ";
        while (" ".equals(sData)) {
            String var = brData.readLine();
            if ("3".equals(var.substring(7, 8))) {
                sData = var.substring(144, 152);
            }
        }
        String dia = sData.substring(0, 2);
        String mes = sData.substring(2, 4);
        String ano = sData.substring(4, 8);
        String completo = dia + "/" + mes + "/" + ano;
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dataPagamento = (Date) formatter.parse(completo);
        
        // CAPTURA A PRIMEIRA LINHA
        FileReader frLinha = new FileReader(arquivo.getPath());
        BufferedReader brLinha = new BufferedReader(frLinha);
        String linha = "";
        while ("".equals(linha)) {
            String var = brLinha.readLine();
            if ("0".equals(var.substring(7, 8))) {
                linha = var;
            }
        }
        
        RetornoBancario ret = inserirRetorno(servico, emp, banco, dataPagamento, arquivo, linha, usuario);

        if (ret == null) {
            JOptionPane.showMessageDialog(null, "Problemas na inclusão do arquivo!");
            return false;
        } else {
            // PROCEDURE PARA INSERIR NA TABELA DADOS
            Boolean procedure = DaoFactory.getRetornoBancarioDao().executarProcedure(ret, usuario, dataInc);
            if (procedure != true) {
                JOptionPane.showMessageDialog(null, "Importação realizada com sucesso.");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Problema na rotina de distribuição.");
                return false;
            }
        }
    }
}

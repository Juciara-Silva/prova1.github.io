package controllers;

import java.util.List;

import models.Produto;
import play.mvc.Controller;
import play.mvc.results.Result;

public class Produtos extends Controller {
	
	public static void form() {
        render();
}
	public static void salvar(Produto p) {
	    p.save();
	    String mensagem = "Cadastrado com sucesso!";
	    flash.success(mensagem);
	    listar("");
	}
	 
	 
	 public static void listar(String termo) {
			List<Produto> produtos = Produto.findAll();
			int totalQuant = quantidadeTotal(produtos);
			render(produtos, termo, totalQuant);
		}
	 
	  
	 public static void remover(long id) {
		 Produto p = Produto.findById(id);
		 if (p != null) {
			p.delete();
			flash.success("Removido com sucesso!");
		 }else {
			 flash.error("produto não encontrado!");
		 }
			listar(null);
	 }

	 
	 public static int quantidadeTotal(List<Produto> produtos) {
		 int total = 0;
		 for (Produto p : produtos) {
			 total += p.quantidade;
		 }
		 return total;
	 }
	 

}
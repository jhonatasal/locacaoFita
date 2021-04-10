package br.com.jhonatasa_s.Locadora.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;

public interface CrudController<T> {

	public String listar(ModelMap model);

	public String salvar(T entity);

	public String excluir(@PathVariable("id") Integer id);

	public String editarPag(@PathVariable("id") Integer id, ModelMap model);

	public String editar(T entity);
}

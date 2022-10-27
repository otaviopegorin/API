package br.com.ApiStage3.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

@Repository("jDBCController")
public class JDBCController {

	@Autowired  
    JdbcTemplate jdbc; 
	
	public void BuscarPedido(){  
		String query="select u.img_usuario, u.nome,  p.nome, iv.quantidade, v.data_venda\r\n"
				+ "from usuario u join produto p join venda v join item_venda iv \r\n"
				+ "where u.id_usuario = v.usuario_id_usuario and iv.venda_id_venda = v.id_venda \r\n"
				+ "and iv.produto_id_produto = p.id_produto ";  
		jdbc.execute(query,new PreparedStatementCallback<Boolean>(){  
		    @Override  
		    public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException {  	               
		        return ps.execute();  	              
		    }  
		});    
        System.out.println("Data inserted Successfully");  
    }
}

package br.com.meusprojetos.gerenciadorprodutos.exception;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ProdutoNaoEncontradoException.class)
	public ResponseEntity<ErrorResponse> handleValidacao(ProdutoNaoEncontradoException ex, HttpServletRequest request) {
		ErrorResponse response = new ErrorResponse();
				response.setTimestamp(LocalDateTime.now());
				response.setStatus(HttpStatus.NOT_FOUND.value());
				response.setError("Resource not found.");
				response.setMessage(ex.getMessage());
				response.setPath(request.getRequestURI());
					
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
}

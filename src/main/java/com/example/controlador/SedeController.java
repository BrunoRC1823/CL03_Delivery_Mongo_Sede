package com.example.controlador;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entidad.Sede;
import com.example.service.SedeService;

@RestController
@RequestMapping("/rest/sede")
public class SedeController {
	@Autowired
	private SedeService sedeService;

	@PostMapping
	public ResponseEntity<?>  inserta(@RequestBody Sede obj){
		HashMap<String, Object> salida = new HashMap<>();
		try {
			obj.setFechaRegistro(LocalDateTime.now());
			Sede objSalida = sedeService.ingresarSede(obj);
			if(objSalida == null) {
				salida.put("mensaje", "No se registro la sede");
				return new ResponseEntity<>(salida, HttpStatus.BAD_REQUEST);
			}
			salida.put("mensaje", "Registro exitoso!");
			return ResponseEntity.ok(salida);
		} catch (DataAccessException e) {
			salida.put("mensaje", "Error al registrar la sede");
			salida.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<HashMap<String, Object>>(salida, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

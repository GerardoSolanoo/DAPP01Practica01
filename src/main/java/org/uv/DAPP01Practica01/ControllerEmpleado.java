/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package org.uv.DAPP01Practica01;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author sgerardov
 */
@RestController
@RequestMapping("/empleado")
public class ControllerEmpleado {
    
    @GetMapping()
    public List<DTOEmpleado> list() {
        List<DTOEmpleado> listaEmpleado = new ArrayList<>();
        DTOEmpleado e1 = new DTOEmpleado();
        e1.setClave(10L);
        e1.setNombre("Marlene");
        e1.setDireccion("Monte white");
        e1.setTelefono("2711843660");
        listaEmpleado.add(e1);
        return listaEmpleado;
    }
    
    @GetMapping("/{id}")
    public DTOEmpleado get(@PathVariable Long id) {
        if(id==10L){
            DTOEmpleado e1 = new DTOEmpleado();
            e1.setClave(10L);
            e1.setNombre("Marlene");
            e1.setDireccion("Monte white");
            e1.setTelefono("2711843660");
            return e1;
        } else {
            DTOEmpleado e2 = new DTOEmpleado();
            e2.setClave(11L);
            e2.setNombre("Gerardo");
            e2.setDireccion("Fortín");
            e2.setTelefono("2711843660");
            return e2;
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<DTOEmpleado> put(@PathVariable Long id, @RequestBody DTOEmpleado empToUpdate) {
        if(id==10L){
            DTOEmpleado emp = new DTOEmpleado();
            emp.setClave(10L);
            emp.setNombre("Marlene");
            emp.setDireccion("Monte white");
            emp.setTelefono("2711843660");
            return ResponseEntity.ok(emp);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    public ResponseEntity<DTOEmpleado> post(@RequestBody DTOEmpleado newEmp) {
        DTOEmpleado emp = new DTOEmpleado();
        emp.setClave(100L);
        emp.setNombre(newEmp.getNombre());
        emp.setDireccion(newEmp.getDireccion());
        emp.setTelefono(newEmp.getTelefono());
        
        return ResponseEntity.ok(emp);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {
    }
    
}

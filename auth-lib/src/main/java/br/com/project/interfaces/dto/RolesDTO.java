package br.com.project.interfaces.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RolesDTO {

    private UUID id;
    private String name;
}

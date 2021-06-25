package com.qidaiai.dto;


import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@ApiModel(value = "com-qidaiai-dto-RegistrationFormDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RegistrationFormDto extends BaseDto{

    private PatientDto patientDto;

    private RegistrationDto registrationDto;
}

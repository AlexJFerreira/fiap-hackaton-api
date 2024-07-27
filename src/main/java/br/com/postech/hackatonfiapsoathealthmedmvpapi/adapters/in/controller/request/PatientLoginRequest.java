package br.com.postech.hackatonfiapsoathealthmedmvpapi.adapters.in.controller.request;

public record PatientLoginRequest(String email, String cpf, String password) {
}

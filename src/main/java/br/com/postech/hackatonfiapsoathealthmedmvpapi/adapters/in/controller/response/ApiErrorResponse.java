package br.com.postech.hackatonfiapsoathealthmedmvpapi.adapters.in.controller.response;

public record ApiErrorResponse(
    int errorCode,
    String description) {

}
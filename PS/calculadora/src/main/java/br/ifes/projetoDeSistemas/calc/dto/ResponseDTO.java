package br.ifes.projetoDeSistemas.calc.dto;

public class ResponseDTO {
    private int result = 0;
    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    

    public ResponseDTO(int result) {
        this.result = result;
    }
}

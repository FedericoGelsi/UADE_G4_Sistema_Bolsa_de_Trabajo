package controllers;

import models.vo.CandidatoVO;

import java.util.List;

public class CandidatoController {
    private List<CandidatoVO> candidatos;

    public CandidatoController() {
    }

    public List<CandidatoVO> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(List<CandidatoVO> candidatos) {
        this.candidatos = candidatos;
    }
}

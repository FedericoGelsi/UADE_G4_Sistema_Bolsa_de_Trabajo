package controllers;

import models.enums.Categoria;
import models.enums.Modalidad;
import models.enums.Requisito;
import models.enums.Tipo;
import models.vo.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class InformeControllerTest {

    private InformeController informeController;
    @Mock
    private PublicacionController publicacionController;
    @Mock
    private OfertaController ofertaController;
    private List<OfertaLaboralVO> list;
    private List<PublicacionVO> publicacionesVO;
    private List<PostulanteVO> postulantesVO1;
    private List<PostulanteVO> postulantesVO2;

    @BeforeEach
    void setUp() {
        List<Requisito> requisitos = new ArrayList<>();
        List<Categoria> categorias = new ArrayList<>();

        list = new ArrayList<>();
        postulantesVO1 = new ArrayList<>();
        postulantesVO2 = new ArrayList<>();
        publicacionesVO= new ArrayList<>();
        informeController = new InformeController();

        postulantesVO1.add(new PostulanteVO(1,2021, new CandidatoVO("Nicolas", "Santos", 39402061)));
        postulantesVO1.add(new PostulanteVO(2,2021, new CandidatoVO("Federico", "Gelsi", 40402061)));
        postulantesVO1.add(new PostulanteVO(1,2021, new CandidatoVO("Cecilia", "Huaman", 38402061)));

        postulantesVO2.add(new PostulanteVO(3,2021, new CandidatoVO("Emanuel", "Maidana", 39462061)));
        postulantesVO2.add(new PostulanteVO(1,2021, new CandidatoVO("Ivan", "Chan", 39412098)));

        Collections.addAll(requisitos, Requisito.REQUISITO1, Requisito.REQUISITO2, Requisito.REQUISITO3);
        Collections.addAll(categorias, Categoria.CONTABLE, Categoria.SISTEMAS);

        list.add(new OfertaLaboralVO(
                1,
                "Titulo",
                "Descripcion",
                Modalidad.PART_TIME,
                Tipo.PRESENCIAL,
                "CABA",
                160000.00,
                requisitos,
                categorias
        ));

        list.add(new OfertaLaboralVO(
                        1,
                        "Test",
                        "Testing method",
                        Modalidad.FULL_TIME,
                        Tipo.REMOTO,
                        "Casa",
                        200.00,
                        new ArrayList<>(Collections.singleton(Requisito.REQUISITO1)),
                        new ArrayList<>(Collections.singleton(Categoria.CONTABLE))
                ));

        list.add(new OfertaLaboralVO(1,
                        "Test 2",
                        "Testing method",
                        Modalidad.FULL_TIME,
                        Tipo.REMOTO,
                        "Casa",
                        200.00,
                        new ArrayList<>(Collections.singleton(Requisito.REQUISITO1)),
                        new ArrayList<>(Collections.singleton(Categoria.CONTABLE))
                ));

        list.add(new OfertaLaboralVO(1,
                        "Test 3",
                        "Testing method",
                        Modalidad.FULL_TIME,
                        Tipo.REMOTO,
                        "Casa",
                        200.00,
                        new ArrayList<>(Collections.singleton(Requisito.REQUISITO1)),
                        new ArrayList<>(Collections.singleton(Categoria.SISTEMAS))
                ));

        publicacionesVO.add(new PublicacionVO(new OfertaLaboralVO(1,
                "Test 3",
                "Testing method",
                Modalidad.FULL_TIME,
                Tipo.REMOTO,
                "Casa",
                200.00,
                new ArrayList<>(Collections.singleton(Requisito.REQUISITO1)),
                new ArrayList<>(Collections.singleton(Categoria.SISTEMAS))
        ), LocalDateTime.now(), LocalDateTime.now()));

        publicacionesVO.add(new PublicacionVO(new OfertaLaboralVO(1,
                "Test 2",
                "Testing method",
                Modalidad.FULL_TIME,
                Tipo.REMOTO,
                "Casa",
                200.00,
                new ArrayList<>(Collections.singleton(Requisito.REQUISITO1)),
                new ArrayList<>(Collections.singleton(Categoria.CONTABLE))
        ), LocalDateTime.now(), LocalDateTime.now()));

        publicacionesVO.get(0).setPostulaciones(postulantesVO1);
        publicacionesVO.get(1).setPostulaciones(postulantesVO2);

        publicacionController = mock(PublicacionController.class);
        ofertaController = mock(OfertaController.class);
        EmpresaController empresaController = mock(EmpresaController.class);

        ofertaController.setEmpresaController(empresaController);
        publicacionController.setOfertaController(ofertaController);
        informeController.setPublicacionController(publicacionController);

        when(publicacionController.getPublicaciones()).thenReturn(publicacionesVO);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void TestcategoriasMasSeleccionadas_ShouldReturnInforme() {
        // Arrange
        Integer idEmpresa = 1;
        Integer cantidad = 2;

        InformeVO informeExpected = new InformeVO("Categorias", "CONTABLE;SISTEMAS");

        // Act
        InformeVO informeActual = informeController.categoriasMasSeleccionadas(idEmpresa, cantidad);

        // Assert
        Assertions.assertEquals(informeExpected.getData(), informeActual.getData());

    }

    @Test
    void getReporteMayorOfertasLaborales() {
        // Arrange
        String mes = "1";
        String anio = "2021";

        InformeVO informeExpected = new InformeVO("Test 3", "");

        // Act
        InformeVO informeActual = informeController.getReporteMayorOfertasLaborales(mes, anio);

        // Assert
        Assertions.assertEquals(informeExpected.getTitulo(), informeActual.getTitulo());
    }

    @Test
    void TestgetInformeOfertaMasAccesible() {

    }

    @Test
    void trabajoMasExigente() {
    }
}
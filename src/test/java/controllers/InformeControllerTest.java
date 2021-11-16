package controllers;

import models.enums.Categoria;
import models.enums.Modalidad;
import models.enums.Requisito;
import models.enums.Tipo;
import models.vo.InformeVO;
import models.vo.OfertaLaboralVO;
import models.vo.PostulanteVO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.mockito.junit.jupiter.MockitoExtension;

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

    @BeforeEach
    void setUp() {
        List<Requisito> requisitos = new ArrayList<>();
        List<Categoria> categorias = new ArrayList<>();

        list = new ArrayList<>();
        informeController = new InformeController();

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

        publicacionController = mock(PublicacionController.class);
        ofertaController = mock(OfertaController.class);
        EmpresaController empresaController = mock(EmpresaController.class);

        ofertaController.setEmpresaController(empresaController);
        publicacionController.setOfertaController(ofertaController);
        informeController.setPublicacionController(publicacionController);

        when(publicacionController.getOfertasLaborales(1)).thenReturn(list);
        // when(ofertaController.ObtenerOfertasLaborales(1)).thenReturn((ArrayList<OfertaLaboralVO>) list);
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
    }

    @Test
    void setMiVentanaReporte() {
    }

    @Test
    void getMiVentanaReporte() {
    }

    @Test
    void mostrarVentanaReporte() {
    }

    @Test
    void TestgetInformeOfertaMasAccesible() {

    }

    @Test
    void trabajoMasExigente() {
    }
}
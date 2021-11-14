package models.vo;

import models.enums.Categoria;
import models.enums.Modalidad;
import models.enums.Requisito;
import models.enums.Tipo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PublicacionVOTest {

    private PublicacionVO publicacionVO;

    @BeforeEach
    void setUp() {
        List<Requisito> requisitos = new ArrayList<>();
        Collections.addAll(requisitos, Requisito.REQUISITO1, Requisito.REQUISITO2, Requisito.REQUISITO3);

        List<Categoria> categorias = new ArrayList<>();
        Collections.addAll(categorias, Categoria.CONTABLE, Categoria.SISTEMAS);

        List<PostulanteVO> postulantes = new ArrayList<>();
        Collections.addAll(postulantes, new PostulanteVO(), new PostulanteVO());

        OfertaLaboralVO ofertaLaboralVO = new OfertaLaboralVO(
                "Titulo",
                "Descripcion",
                Modalidad.PART_TIME,
                Tipo.PRESENCIAL,
                "CABA",
                160000.00,
                requisitos,
                categorias,
                postulantes
        );
        publicacionVO = new PublicacionVO(
                ofertaLaboralVO,
                LocalDateTime.now().minusHours(10),
                LocalDateTime.now().plusHours(10)
        );
    }

    @AfterEach
    void tearDown() {
        publicacionVO = null;
    }

    @Test
    void TestPublicacionVO_getTitulo_ShouldNotBeNull() {
        // Arrange

        // Act
        String actual = publicacionVO.getOfertaLaboralVO().getTitulo();
        // Assert
        assertNotNull(actual);
    }

    @Test
    void TestPublicacionVO_getSueldo_ShouldNotBeNull(){
    // Arrange

        // Act
        Double actual = publicacionVO.getOfertaLaboralVO().getSueldo();
        // Assert
        assertNotNull(actual);
    }

    @Test
    void TestPublicacionVO_getPostulaciones_ShouldNotBeNull(){
        // Arrange

        // Act
        List<PostulanteVO> actual = publicacionVO.getPostulaciones();
        // Assert
        assertNotNull(actual);
    }

    @Test
    void TestPublicacionVO_getVigenciaDesde_ShouldNotBeNull(){
        // Arrange

        // Act
        LocalDateTime actual = publicacionVO.getVigenciaDesde();
        // Assert
        assertNotNull(actual);
    }

    @Test
    void TestPublicacionVO_getVigenciaHasta_ShouldNotBeNull(){
        // Arrange

        // Act
        LocalDateTime actual = publicacionVO.getVigenciaHasta();
        // Assert
        assertNotNull(actual);
    }

    @Test
    void TestPublicacionVO_isVigente_ShouldNotBeNull(){
        // Arrange

        // Act
        boolean actual = publicacionVO.isVigente();
        // Assert
        assertNotNull(actual);
    }

    @Test
    void TestPublicacionVO_isVigente_ShouldBeFalseIfVigenciaHastaIsLowerThanLocalDateTimeNow(){
        // Arrange
        LocalDateTime vigenciaHasta = LocalDateTime.of(LocalDate.now(), LocalTime.now().minusMinutes(1));
        publicacionVO.setVigenciaHasta(vigenciaHasta);
        // Act
        boolean actual = publicacionVO.isVigente();
        // Assert
        assertFalse(actual);
    }

    @Test
    void TestPublicacionVO_isVigente_ShouldBeTrueIfVigenciaHastaIsGreaterThanLocalDateTimeNow(){
        // Arrange
        LocalDateTime vigenciaHasta = LocalDateTime.of(LocalDate.now(), LocalTime.now().plusMinutes(1));
        publicacionVO.setVigenciaHasta(vigenciaHasta);
        // Act
        boolean actual = publicacionVO.isVigente();
        // Assert
        assertTrue(actual);
    }

    @Test
    void TestPublicacionVO_isVigente_ShouldBeTrueIfVigenciaDesdeIsLowerThanLocalDateTimeNow(){
        // Arrange
        LocalDateTime vigenciaDesde = LocalDateTime.of(LocalDate.now(), LocalTime.now().minusMinutes(1));
        publicacionVO.setVigenciaDesde(vigenciaDesde);
        // Act
        boolean actual = publicacionVO.isVigente();
        // Assert
        assertTrue(actual);
    }

    @Test
    void TestPublicacionVO_isVigente_ShouldBeFalseIfVigenciaDesdeIsGreaterThanLocalDateTimeNow(){
        // Arrange
        LocalDateTime vigenciaDesde = LocalDateTime.of(LocalDate.now(), LocalTime.now().plusMinutes(1));
        publicacionVO.setVigenciaDesde(vigenciaDesde);
        // Act
        boolean actual = publicacionVO.isVigente();
        // Assert
        assertFalse(actual);
    }
}
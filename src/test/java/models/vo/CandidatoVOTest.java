package models.vo;

import models.enums.Categoria;
import models.enums.Conocimiento;
import models.enums.Idioma;
import models.enums.Requisito;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CandidatoVOTest {

    private CandidatoVO candidatoVO;

    @BeforeEach
    void setUp() {
        candidatoVO = new CandidatoVO(
                "DummyFirstName",
                "DummyLastName",
                12345678
        );

        List<Idioma> idiomas = new ArrayList<>();
        Collections.addAll(idiomas, Idioma.ENGLISH, Idioma.SPANISH);
        candidatoVO.setIdiomas(idiomas);

        List<Conocimiento> conocimientos = new ArrayList<>();
        Collections.addAll(conocimientos, Conocimiento.CONOCIMIENTO1, Conocimiento.CONOCIMIENTO2, Conocimiento.CONOCIMIENTO3);
        candidatoVO.setConocientos(conocimientos);
        List<Categoria> categorias = new ArrayList<>();
        Collections.addAll(categorias, Categoria.CONTABLE, Categoria.SISTEMAS);
        candidatoVO.setCategorias(categorias);

        candidatoVO.setFechaNacimiento(LocalDate.now());
        candidatoVO.setNacionalidad("Argentina");
    }

    @AfterEach
    void tearDown() {
        candidatoVO = null;
    }

    @Test
    void TestCandidatoVO_getNombre_ShouldNotBeNull() {
        // Arrange

        // Act
        String actual = candidatoVO.getNombre();
        // Assert
        assertNotNull(actual);
    }

    @Test
    void setNombre() {
    }

    @Test
    void TestCandidatoVO_getApellido_ShouldNotBeNull() {
        // Arrange

        // Act
        String actual = candidatoVO.getApellido();
        // Assert
        assertNotNull(actual);
    }

    @Test
    void TestCandidatoVO_getDNI_ShouldNotBeNull() {
        // Arrange

        // Act
        Integer actual = candidatoVO.getDNI();
        // Assert
        assertNotNull(actual);
    }

    @Test
    void TestCandidatoVO_getFechaNacimiento_ShouldNotBeNull() {
        // Arrange

        // Act
        LocalDate actual = candidatoVO.getFechaNacimiento();
        // Assert
        assertNotNull(actual);
    }

    @Test
    void TestCandidatoVO_getFechaNacimiento_ShouldHaveAnSpecificFormat() {
        // Arrange
        // Date should only have day, month and year.
        LocalDate expected = LocalDate.now();
        // Act
        candidatoVO.setFechaNacimiento(LocalDate.now());
        LocalDate actual = candidatoVO.getFechaNacimiento();
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void TestCandidatoVO_getNacionalidad_ShouldNotBeNull() {
        // Arrange

        // Act
        String actual = candidatoVO.getNacionalidad();
        // Assert
        assertNotNull(actual);
    }

    @Test
    void TestCandidatoVO_getConocimientos_ShouldNotBeNull() {
        // Arrange

        // Act
        List<Conocimiento> actual = candidatoVO.getConocientos();
        // Assert
        assertNotNull(actual);
    }

    @Test
    void TestCandidatoVO_getConocimientos_ShouldHaveAtLeastOneItem() {
        // Arrange

        // Act
        boolean actual = candidatoVO.getConocientos().isEmpty();
        // Assert
        assertFalse(actual);
    }

    @Test
    void TestCandidatoVO_getIdiomas_ShouldNotBeNull() {
        // Arrange

        // Act
        List<Idioma> actual = candidatoVO.getIdiomas();
        // Assert
        assertNotNull(actual);
    }

    @Test
    void TestCandidatoVO_getIdiomas_ShouldHaveAtLeastOneItem() {
        // Arrange

        // Act
        boolean actual = candidatoVO.getIdiomas().isEmpty();
        // Assert
        assertFalse(actual);
    }

    @Test
    void TestCandidatoVO_getCategorias_ShouldNotBeNull() {
        // Arrange

        // Act
        List<Categoria> actual = candidatoVO.getCategorias();
        // Assert
        assertNotNull(actual);
    }

    @Test
    void TestCandidatoVO_getCategorias_ShouldHaveAtLeastOneItem() {
        // Arrange

        // Act
        boolean actual = candidatoVO.getCategorias().isEmpty();
        // Assert
        assertFalse(actual);
    }

    @Test
    void TestCandidatoVO_setDNI_ShouldSetDNI() {
        // Arrange
        Integer expected = 39431234;
        // Act
        candidatoVO.setDNI(expected);
        Integer actual = candidatoVO.getDNI();
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void TestCandidatoVO_setNombre_ShouldSetNombre() {
        // Arrange
        String expected = "DummyName1";
        // Act
        candidatoVO.setNombre(expected);
        String actual = candidatoVO.getNombre();
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void TestCandidatoVO_getUserId_ShouldReturnDifferentIDsfor2DifferentObjects() {
        // Arrange
        Integer expected = new CandidatoVO().getUserId();
        // Act
        Integer actual = candidatoVO.getUserId();
        // Assert
        assertNotEquals(expected, actual);
    }

}
package models.vo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OfertaLaboralVOTest {

    private OfertaLaboralVO ofertaLaboralVO;

    @BeforeEach
    public void setUp() {
        ofertaLaboralVO = new OfertaLaboralVO();
    }

    @AfterEach
    public void tearDown() {
        ofertaLaboralVO = null;
    }

    @Test
    public void TestOfertaLaboralVO_Constructor_ShouldNotBeNull(){
        //Assert
        Assertions.assertNotNull(ofertaLaboralVO);
    }

    @Test
    public void TestOfertaLaboralVO_GetTitulo_ShouldReturnsTitulo(){
        //Arrange
        String expected = "Titulo";

        //Act
        String actual = ofertaLaboralVO.getTitulo();

        //Assert
        Assertions.assertEquals(expected, actual);
    }
}
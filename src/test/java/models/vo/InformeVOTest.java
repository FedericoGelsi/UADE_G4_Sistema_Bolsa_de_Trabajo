package models.vo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InformeVOTest {

    private InformeVO informeVO;

    @BeforeEach
    void setUp() {
        informeVO = new InformeVO(
                "DummyTitle",
                "DummyData"
        );
    }

    @AfterEach
    void tearDown() {
        informeVO = null;
    }

    @Test
    void TestInformeVO_getTitulo_ShouldNotReturnNull() {
        // Arrange
        // Act
        String actual = informeVO.getTitulo();
        // Assert
        assertNotNull(actual);
    }

    @Test
    void TestInformeVO_setTitulo_ShouldSetTitulo() {
        // Arrange
        String expected = "NewTitle";
        // Act
        informeVO.setTitulo(expected);
        String actual = informeVO.getTitulo();
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void TestInformeVO_getInformeId_ShouldNotReturnNull() {
        // Arrange
        // Act
        Integer actual = informeVO.getInformeId();
        // Assert
        assertNotNull(actual);
    }

    @Test
    void TestInformeVO_getInformeId_ShouldReturnTwoDifferentIDsfor2DifferentObjects() {
        // Arrange
        InformeVO newinformeVO = new InformeVO("DummyTitle2", "Data2");
        Integer expected = newinformeVO.getInformeId();
        // Act
        Integer actual = informeVO.getInformeId();
        // Assert
        assertNotEquals(expected, actual);
    }


    @Test
    void TestInformeVO_getData_ShouldNotReturnNull() {
        // Arrange
        // Act
        String actual = informeVO.getData();
        // Assert
        assertNotNull(actual);
    }

    @Test
    void TestInformeVO_setData_ShouldSetTitulo() {
        // Arrange
        String expected = "NewData";
        // Act
        informeVO.setData(expected);
        String actual = informeVO.getData();
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void TestInformeVO_setCantidad_entre_fechas_ShouldsetCantidad_entre_fechas() {
        // Arrange
        Integer expected = 240;
        // Act
        informeVO.setCantidad_entre_fechas(expected);
        Integer actual = informeVO.getCantidad_entre_fechas();
        // Assert
        assertEquals(expected, actual);
    }
}
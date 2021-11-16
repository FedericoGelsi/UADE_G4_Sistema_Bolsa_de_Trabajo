package models.vo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpresaVOTest {

    private EmpresaVO empresaVO;

    @BeforeEach
    void setUp() {
        empresaVO = new EmpresaVO(
                "DummyName",
                2039878315
        );
    }

    @AfterEach
    void tearDown() {
        empresaVO = null;
    }

    @Test
    void TestEmpresaVO_getNombre_ShouldNotReturnNull() {
        // Arrange
        // Act
        String actual = empresaVO.getNombre();
        // Assert
        assertNotNull(actual);
    }

    @Test
    void TestEmpresaVO_setNombre_ShouldSetNombre() {
        // Arrange
        String expected = "NewName";
        // Act
        empresaVO.setNombre(expected);
        String actual = empresaVO.getNombre();
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void TestEmpresaVO_getCuit_ShouldNotReturnNull() {
        // Arrange
        // Act
        Integer actual = empresaVO.getCuit();
        // Assert
        assertNotNull(actual);
    }

    @Test
    void TestEmpresaVO_setCuit_ShouldSetCuit() {
        // Arrange
        Integer expected = Integer.parseInt("2039278315");
        // Act
        empresaVO.setCuit(expected);
        Integer actual = empresaVO.getCuit();
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void TestEmpresaVO_getEmpresaId_ShouldReturnDifferentIDsfor2DifferentObjects() {
        // Arrange
        Integer expected = new EmpresaVO("DummyName", 0).getEmpresaId();
        // Act
        Integer actual = empresaVO.getEmpresaId();
        // Assert
        assertNotEquals(expected, actual);
    }
}
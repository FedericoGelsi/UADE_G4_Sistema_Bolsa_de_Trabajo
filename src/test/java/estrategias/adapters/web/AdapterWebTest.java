package estrategias.adapters.web;

import models.vo.InformeVO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class AdapterWebTest {

    private IAdapterWeb adapterWeb;

    @BeforeEach
    void setUp() {
        adapterWeb = new AdapterWeb();
    }

    @AfterEach
    void tearDown() {
        adapterWeb = null;
    }

    @Test
    void TestAdapterWeb_generarWeb_ShouldNotThrowAnyException() {
        // Arrange
        InformeVO informeVO = mock(InformeVO.class);
        // Act
        // Assert
        assertDoesNotThrow(() -> adapterWeb.generarWeb(informeVO));
    }
}
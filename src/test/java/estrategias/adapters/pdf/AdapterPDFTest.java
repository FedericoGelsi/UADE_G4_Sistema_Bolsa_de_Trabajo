package estrategias.adapters.pdf;

import estrategias.adapters.web.AdapterWeb;
import models.vo.InformeVO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class AdapterPDFTest {

    private IAdapterPDF adapterPDF;

    @BeforeEach
    void setUp() {
        adapterPDF = new AdapterPDF();
    }

    @AfterEach
    void tearDown() {
        adapterPDF = null;
    }

    @Test
    void TestAdapterPDF_generarWeb_ShouldNotThrowAnyException() {
        // Arrange
        InformeVO informeVO = mock(InformeVO.class);
        // Act
        // Assert
        assertDoesNotThrow(() -> adapterPDF.generarPDF(informeVO));
    }
}
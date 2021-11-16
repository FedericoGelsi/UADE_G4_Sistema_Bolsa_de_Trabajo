package estrategias;

import controllers.PublicacionController;
import estrategias.adapters.pdf.AdapterPDF;
import estrategias.adapters.pdf.IAdapterPDF;
import models.vo.InformeVO;
import models.vo.PublicacionVO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class VisualizacionPDFTest {

    private VisualizacionPDF visualizacionPDF;

    @Mock
    private IAdapterPDF adapterPDFMock;

    @BeforeEach
    void setUp() {
        adapterPDFMock = mock(AdapterPDF.class);
        visualizacionPDF = new VisualizacionPDF(adapterPDFMock);
    }

    @AfterEach
    void tearDown() {
        adapterPDFMock = null;
        visualizacionPDF = null;
    }

    @Test
    void TestVisualizacionPDF_setAdapter_ShouldNotThrowAnyException() {
        // Arrange
        IAdapterPDF expected = mock(AdapterPDF.class);
        // Act
        // Assert
        assertDoesNotThrow(() -> visualizacionPDF.setAdapter(expected));
    }

    @Test
    void generarInforme() {

    }
}
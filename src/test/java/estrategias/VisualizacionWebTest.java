package estrategias;

import estrategias.adapters.pdf.AdapterPDF;
import estrategias.adapters.pdf.IAdapterPDF;
import estrategias.adapters.web.AdapterWeb;
import estrategias.adapters.web.IAdapterWeb;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class VisualizacionWebTest {

    private VisualizacionWeb visualizacionWeb;

    @Mock
    private IAdapterWeb adapterWebMock;

    @BeforeEach
    void setUp() {
        adapterWebMock = mock(AdapterWeb.class);
        visualizacionWeb = new VisualizacionWeb( adapterWebMock);
    }

    @AfterEach
    void tearDown() {
        adapterWebMock = null;
        visualizacionWeb = null;
    }

    @Test
    void TestVisualizacionWeb_setAdapter_ShouldNotThrowAnyException() {
        // Arrange
        IAdapterWeb expected = mock(AdapterWeb.class);
        // Act
        // Assert
        assertDoesNotThrow(() -> visualizacionWeb.setAdapter(expected));
    }

    @Test
    void generarInforme() {

    }
}
package models.vo;

import exceptions.PostulanteException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostulanteVOTest {

    private PostulanteVO postulanteVO;

    @BeforeEach
    void setUp() {
        postulanteVO = new PostulanteVO(
            12,
                21,
                new CandidatoVO()
        );
    }

    @AfterEach
    void tearDown() {
        postulanteVO = null;
    }

    @Test
    void TestPostulanteVO_getMes_ShouldNotBeNull() {
        // Arrange
        // Act
        Object actual = postulanteVO.getMes();
        // Assert
        assertNotNull(actual);
    }

    @Test
    void TestPostulanteVO_getMes_ShouldReturnInteger() {
        // Arrange
        String expected = Integer.class.getSimpleName();
        // Act
        String actual = postulanteVO.getMes().getClass().getSimpleName();
        // Assert
        assertEquals(expected , actual);
    }

    @Test
    void TestPostulanteVO_getAnio_ShouldNotBeNull() {
        // Arrange
        // Act
        Object actual = postulanteVO.getMes();
        // Assert
        assertNotNull(actual);
    }

    @Test
    void TestPostulanteVO_getAnio_ShouldReturnInteger() {
        // Arrange
        String expected = Integer.class.getSimpleName();
        // Act
        String actual = postulanteVO.getAnio().getClass().getSimpleName();
        // Assert
        assertEquals(expected , actual);
    }

    @Test
    void TestPostulanteVO_getCandidato_ShouldReturnCandidatoVO() {
        // Arrange
        String expected = CandidatoVO.class.getSimpleName();
        // Act
        String actual = postulanteVO.getCandidato().getClass().getSimpleName();
        // Assert
        assertEquals( expected, actual);
    }


    @Test
    void TestPostulanteVO_setCandidato_ShouldThrowAnException_WhenCantidatoIsNull(){
        // Arrange
        CandidatoVO candidatoVO = null;
        String expected = "Cantidato no puede estar vacío.";
        String actual = "";
        // Act
        // Assert
        PostulanteException e = assertThrows( PostulanteException.class , () -> postulanteVO.setCandidato(candidatoVO));
        actual = e.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    void TestPostulanteVO_setCandidato_ShouldsetCandidato_WhenCantidatoIsNotNull() throws PostulanteException {
        // Arrange
        CandidatoVO expected = new CandidatoVO("DummyName", "DummyName", 1);
        // Act
        postulanteVO.setCandidato(expected);
        CandidatoVO actual = postulanteVO.getCandidato();
        // Assert
        assertEquals(expected, actual);
    }
}
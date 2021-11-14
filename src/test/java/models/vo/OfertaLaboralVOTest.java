package models.vo;

import models.enums.Categoria;
import models.enums.Modalidad;
import models.enums.Requisito;
import models.enums.Tipo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class OfertaLaboralVOTest {

    private OfertaLaboralVO ofertaLaboralVO;

    @BeforeEach
    public void setUp() {
        List<Requisito> requisitos = new ArrayList<>();
        Collections.addAll(requisitos, Requisito.REQUISITO1, Requisito.REQUISITO2, Requisito.REQUISITO3);

        List<Categoria> categorias = new ArrayList<>();
        Collections.addAll(categorias, Categoria.CONTABLE, Categoria.SISTEMAS);

        List<PostulanteVO> postulantes = new ArrayList<>();
        Collections.addAll(postulantes, new PostulanteVO(), new PostulanteVO());

        ofertaLaboralVO = new OfertaLaboralVO(
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
    public void TestOfertaLaboralVO_GetTitulo_ShouldReturnsString(){
        //Arrange
        String expected = "Titulo";

        //Act
        Object actual = ofertaLaboralVO.getTitulo();

        //Assert
        Assertions.assertEquals(getType(expected), getType(actual));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestOfertaLaboralVO_GetDescripcion_ReturnsString(){
        //Arrange
        String expected = "Descripcion";
        //Act
        Object actual = ofertaLaboralVO.getDescripcion();
        //Assert
        Assertions.assertEquals(getType(expected), getType(actual));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestOfertaLaboralVO_GetDescripcion_ShouldNotBeNull(){
        //Arrange
        //Act
        Object actual = ofertaLaboralVO.getDescripcion();
        //Assert
        Assertions.assertNotNull(actual);
    }

    @Test
    public void TestOfertaLaboralVO_GetModalidad_ShouldNotBeNull(){
        //Arrange
        //Act
        Object actual = ofertaLaboralVO.getModalidad();
        //Assert
        Assertions.assertNotNull(actual);
    }

    @Test
    public void TestOfertaLaboralVO_GetTipo_ShouldNotBeNull(){
        //Arrange
        //Act
        Object actual = ofertaLaboralVO.getTipo();
        //Assert
        Assertions.assertNotNull(actual);
    }

    @Test
    public void TestOfertaLaboralVO_GetLugar_ShouldBeNullIfTipoIsRemoto(){
        //Arrange
        ofertaLaboralVO.setTipo(Tipo.REMOTO);
        //Act
        Object actual = ofertaLaboralVO.getLugar();
        //Assert
        Assertions.assertNull(actual);
    }

    @Test
    public void TestOfertaLaboralVO_GetLugar_ShouldNotBeNullIfTipoIsPresencial(){
        //Arrange
        //Act
        Object actual = ofertaLaboralVO.getLugar();
        //Assert
        Assertions.assertNotNull(actual);
    }

    @Test
    public void TestOfertaLaboralVO_GetLugar_ShouldNotHaveAnyNumbers(){
        //Arrange
        //Act
        String actual = ofertaLaboralVO.getLugar();
        //Assert
        Assertions.assertFalse(actual.matches(".*\\d.*"));

    }

    @Test
    public void TestOfertaLaboralVO_GetCategorias_ShouldNotBeNull(){
        //Arrange
        //Act
        Object actual = ofertaLaboralVO.getCategorias();
        //Assert
        Assertions.assertNotNull(actual);
    }

    @Test
    public void TestOfertaLaboralVO_GetCategorias_ShouldReturnAtLeastOneItem(){
        //Arrange
        //Act
        List<Categoria> actual = ofertaLaboralVO.getCategorias();
        //Assert
        Assertions.assertFalse(actual.isEmpty());
    }

    @Test
    public void TestOfertaLaboralVO_GetRequisitos_ShouldNotBeNull(){
        //Arrange
        //Act
        Object actual = ofertaLaboralVO.getRequisitos();
        //Assert
        Assertions.assertNotNull(actual);
    }

    @Test
    public void TestOfertaLaboralVO_GetRequisitos_ShouldReturnAtLeastOneItem(){
        //Arrange
        //Act
        List<Requisito> actual = ofertaLaboralVO.getRequisitos();
        //Assert
        Assertions.assertFalse(actual.isEmpty());
    }

    @Test
    public void TestOfertaLaboralVO_GetSueldo_ShouldNotBeNull(){
        //Arrange
        //Act
        Object actual = ofertaLaboralVO.getSueldo();
        //Assert
        Assertions.assertNotNull(actual);
    }

    @Test
    public void TestOfertaLaboralVO_GetSueldo_ShouldBeGreaterThanZero(){
        //Arrange
        //Act
        Double actual = ofertaLaboralVO.getSueldo();
        //Assert
        Assertions.assertTrue(actual > 0.0 );
    }

    @Test
    public void TestOfertaLaboralVO_GetId_ShouldNotBeNull(){
        //Arrange
        //Act
        Object actual = ofertaLaboralVO.getId();
        //Assert
        Assertions.assertNotNull(actual);
    }

    @Test
    public void TestOfertaLaboralVO_GetId_ShouldBeGreaterThanZero(){
        //Arrange
        //Act
        Integer actual = ofertaLaboralVO.getId();
        //Assert
        Assertions.assertTrue(actual > 0 );
    }

    @Test
    public void TestOfertaLaboralVO_GetPostulantes_ShouldNotBeNull(){
        //Arrange
        //Act
        Object actual = ofertaLaboralVO.getPostulantes();
        //Assert
        Assertions.assertNotNull(actual);
    }

    @Test
    public void TestOfertaLaboralVO_SetTipo_ShouldChangeLugarToNullIfTipoIsREMOTO(){
        //Arrange
        String previousLugar = ofertaLaboralVO.getLugar();

        //Act
        ofertaLaboralVO.setTipo(Tipo.REMOTO);
        Object actual = ofertaLaboralVO.getLugar();
        //Assert
        Assertions.assertNotEquals(previousLugar, actual);
        Assertions.assertNull(actual);
    }


    private static <T> String getType(Object obj){
        return obj.getClass().getSimpleName();
    }
}
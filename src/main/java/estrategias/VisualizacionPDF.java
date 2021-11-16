package estrategias;

import estrategias.adapters.pdf.IAdapterPDF;
import models.vo.InformeVO;

public class VisualizacionPDF implements IEstrategiaDeVisualizacion {
    private IAdapterPDF adapter;

    public VisualizacionPDF(IAdapterPDF adapter) {
        super();
        this.adapter = adapter;
    }

    public void setAdapter(IAdapterPDF adapter) {
        this.adapter = adapter;
    }

    @Override
    public void generarInforme(InformeVO informe) {
        this.adapter.generarPDF(informe);
    }
}

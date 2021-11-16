package estrategias;

import estrategias.adapters.web.IAdapterWeb;
import models.vo.InformeVO;

public class VisualizacionWeb implements IEstrategiaDeVisualizacion {
    private IAdapterWeb adapter;

    public VisualizacionWeb(IAdapterWeb adapter) {
        super();
        this.adapter = adapter;
    }

    public void setAdapter(IAdapterWeb adapter) {
        this.adapter = adapter;
    }

    @Override
    public void generarInforme(InformeVO informe) {
        this.adapter.generarWeb(informe);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grafico;

import gui.Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import modelo.Resultado;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class Grafico {
	private ChartPanel chartPanel;
    public Grafico(Main frame/*JFrame principal*/, JPanel panel/*Panel onde estÃ¡ o JfreeChart*/, 
			    		List<Resultado> resltSegChance , List<Resultado> resltNUR, 
						List<Resultado> resltMRU, List<Resultado> resltRAND,
						List<Resultado> resltMFU, List<Resultado> resltOtimo) {

        panel.removeAll();
        final XYDataset dataset = createDataset(resltSegChance, resltNUR, resltMRU, resltRAND, resltMFU, resltOtimo);
        final JFreeChart chart = createChart(dataset);

        chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 380));
      /*  panel.add(chartPanel);
        panel.setVisible(true);*/
        JFrame j = new JFrame();
        j.setSize(640, 480);
        j.setLayout(new BorderLayout());
        JPanel p = new JPanel();
        p.add(chartPanel);
        j.add(p);
        j.setVisible(true);
        
        //frame.pack();
    }

    private JFreeChart createChart(final XYDataset dataset) {

        // create the chart...
        final JFreeChart chart = ChartFactory.createXYLineChart(
                "Algoritmos de Substituição de Páginas - Sistemas Operacionais", // Título
                "Frames", // Eixo X
                "Acertos", // Eixo Y
                dataset, // data
                PlotOrientation.VERTICAL,
                true, // include legend
                true, // tooltips
                false // urls
                );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        chart.setBackgroundPaint(Color.white);

//        final StandardLegend legend = (StandardLegend) chart.getLegend();
        //      legend.setDisplaySeriesShapes(true);

        // get a reference to the plot for further customisation...
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        renderer.setSeriesShapesVisible(0, true);
        renderer.setSeriesShapesVisible(1, true);
        renderer.setSeriesShapesVisible(2, true);
        renderer.setSeriesShapesVisible(3, true);
        renderer.setSeriesShapesVisible(4, true);
        renderer.setSeriesShapesVisible(5, true);
        plot.setRenderer(renderer);

        // change the auto tick unit selection to integer units only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        // OPTIONAL CUSTOMISATION COMPLETED.

        return chart;

    }

    private XYDataset createDataset(List<Resultado> resltSegChance , List<Resultado> resltNUR, 
    								List<Resultado> resltMRU, List<Resultado> resltRAND,
    								List<Resultado> resltMFU, List<Resultado> resltOtimo) {
        final XYSeries segundaChance = new XYSeries("Segunda Chance");
        final XYSeries nur = new XYSeries("NUR");
        final XYSeries mru = new XYSeries("MRU");
        final XYSeries rand = new XYSeries("RAND");
        final XYSeries mfu = new XYSeries("MFU");
        final XYSeries otimo = new XYSeries("OTIMO");

        for (int i = 0; i < resltRAND.size(); i++) {
        	
            segundaChance.add(resltSegChance.get(i).getTamMemoria(), resltSegChance.get(i).getAcerto());
            nur.add(resltNUR.get(i).getTamMemoria(), resltNUR.get(i).getAcerto());
            mru.add(resltMRU.get(i).getTamMemoria(), resltMRU.get(i).getAcerto());
            rand.add(resltRAND.get(i).getTamMemoria(), resltRAND.get(i).getAcerto());
            mfu.add(resltMFU.get(i).getTamMemoria(), resltMFU.get(i).getAcerto());
            otimo.add(resltOtimo.get(i).getTamMemoria(), resltRAND.get(i).getAcerto());
        }

        final XYSeriesCollection dataset = new XYSeriesCollection();
        
        dataset.addSeries(segundaChance);
        dataset.addSeries(nur);
        dataset.addSeries(mru);
        dataset.addSeries(rand);
        dataset.addSeries(mfu);
        dataset.addSeries(otimo);
        return dataset;
    }

	public ChartPanel getChartPanel() {
		return chartPanel;
	}

	public void setChartPanel(ChartPanel chartPanel) {
		this.chartPanel = chartPanel;
	}
    
    
    
}


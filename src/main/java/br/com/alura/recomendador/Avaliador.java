package br.com.alura.recomendador;

import java.io.IOException;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.common.RandomUtils;

public class Avaliador {
	public static void main(String[] args) throws IOException, TasteException {
		
		RandomUtils.useTestSeed();
		
		DataModel model = new Recomendador().getModeloDeProdutos();
		
		RecommenderEvaluator evaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();
		RecommenderBuilder builder = new RecomendadorBuilder();
		double erro = evaluator.evaluate(builder, null, model, 0.9, 1.0);
		
		System.out.println(erro);
	}
}

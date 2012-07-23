import java.io.File;
import java.util.List;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;


public class NewRecommender {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		DataModel model = new FileDataModel( new File("ua.base"));
		
		UserSimilarity similarity = new PearsonCorrelationSimilarity (model);
		
		UserNeighborhood neighborhood = new NearestNUserNeighborhood(2, similarity, model);
		
		Recommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
		
		List<RecommendedItem> recommendations = recommender.recommend(1, 10);
		
		
		System.out.println("Recomendações");
		for(RecommendedItem recommendation : recommendations){
			System.out.println(recommendation.getItemID());			
		}

	}

}

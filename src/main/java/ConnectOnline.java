import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


public class ConnectOnline {
    public static void main(String[] args) {



        MongoClientURI uri = new MongoClientURI(
                "mongodb://tathagat289:Tath1993@cluster0-shard-00-00-dvk24.mongodb.net:27017,cluster0-shard-00-01-dvk24.mongodb.net:27017,cluster0-shard-00-02-dvk24.mongodb.net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin&retryWrites=true&w=majority");

        MongoClient mongoClient = new MongoClient(uri);
        String s = "Tath1993";
//        MongoCredential credential = MongoCredential.createCredential("tathagat289", "test",s.toCharArray() );
//        MongoClient mongoClient = new MongoClient(new ServerAddress(), Arrays.asList(credential));
      MongoDatabase database = mongoClient.getDatabase("test");


        System.out.println("database connected");
        try {
            mongoClient.getAddress();
            System.out.println("try block has run and give the address as :");
            System.out.println(mongoClient.getAddress());
        } catch (Exception e) {
            System.out.println("Database unavailable!");
            mongoClient.close();
            return;
        }



        MongoCollection<Document> collection = database.getCollection("collection");
        System.out.println("Collection collection selected successfully");


        //creating a collection
        database.createCollection("sampleCollection");
//        System.out.println("Collection created successfully");

    }



}

interface QueryBuilder {
    // this will contain the common methods
    public String from();   
    public Query getQuery();   
}

interface Query {

	void execute();
	
}


// this is the implementaiton
class MongoDbQuery implements Query {

	private String from;
	
	private String where;
	
	@Override
	public void execute() {
        // HERE WE NOW EXECUTE THE SPECIFIC QUERY FOR THE PARTICULAR DATABASE
		System.out.println("Executing mongoDbQuery from: "+from+" where "+where);
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setWhere(String where) {
		this.where = where;
	}
	
	

}

class MongoDbQueryBuilder implements QueryBuilder{

    private MongoDbQuery query = new MongoDbQuery();

    @Override
    public String from() {
        return null;
    }

    @Override
    public Query getQuery() {
        return query;
    }

}

class SqlQuery implements Query{

    private String from;
	
	private String where;
	
	@Override
	public void execute() {
        // HERE WE NOW EXECUTE THE SPECIFIC QUERY FOR THE PARTICULAR DATABASE
		System.out.println("Executing mongoDbQuery from: "+from+" where "+where);
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setWhere(String where) {
		this.where = where;
	}

}

class SqlQueryBuilder implements QueryBuilder{

    // returning sql specific query
    private SqlQuery query = new SqlQuery();


	@Override
	public Query getQuery() {
		return query;
	}

    @Override
    public String from() {
        // TODO Auto-generated method stub
        return null;
    }


}

// now this query builder is what get called and we pass in our from and the 
// query builder for the specific language


class QueryBuildDirector {

	/**
	 * Creates a query bases on the from and the where
	 * @param from
	 * @param builder to define end result of the query or the respresnetation of the query
	 * @return
	 */
	public Query buildQuery(String from,QueryBuilder builder){
		builder.from();
        return builder.getQuery();
	}
	
	
}



// EXAMPLE

QueryBuildDirector query  = new QueryBuildDirector();

// querying the mongo db databse with it ouwn builder
query.buildQuery("user",new MongoDbQueryBuilder()); 


// querying the mongo db databse with it ouwn builder
query.buildQuery("user",new SqlQueryBuilder()); 
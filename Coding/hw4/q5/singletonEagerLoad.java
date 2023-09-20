public interface singletonEagerLoad {
    private static final singletonEagerLoad instance = new singletonEagerLoad();

    private singletonEagerLoad(){}

    public singletonEagerLoad getInstance(){
        return instance;
    }
}

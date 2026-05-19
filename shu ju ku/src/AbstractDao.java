public abstract class AbstractDao implements IDAO{
    public AbstractDao() {
        super();
    }

    //void connect();
    @Override
    public void add() {
        System.out.println("新增");
    }

    @Override
    public void del() {
        System.out.println("删除");
    }

    @Override
    public void upd() {
        System.out.println("修改");
    }

    @Override
    public void sel() {
        System.out.println("查询");
    }
}

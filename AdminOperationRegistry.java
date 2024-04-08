@Component
@Qualifier("storeOperationRegistry")
public class AdminOperationRegistry extends AbstractOperationsRegistry {


    public static final String OPEN_STORE = "OPEN";
    public static final String CLOSE_STORE = "CLOSE";
    public static final String FORCE_CLOSE_STORE = "FORCE_CLOSE";
    public static final String STATUS_STORE = "FETCH_STATUS";

    public StoreOperationRegistry(){
        registerOperation(STATUS_STORE,new Operation(IAdmin.class, IAdmin::getStatus));
        registerOperation(OPEN_STORE,new Operation(IAdmin.class, IAdmin::openStore));
        registerOperation(CLOSE_STORE,new Operation(IManager.class, IManager::closeStore));
        registerOperation(FORCE_CLOSE_STORE,new Operation(IManager.class, IManager::forceCloseStore));
    }

or

public StoreOperationRegistry(IAdmin(@Qualifier ="adminService") adminService, IManager(@Qualifier ="managerService") managerService){
        registerOperation(STATUS_STORE,new Operation(adminService.class, adminService::getStatus));
        registerOperation(OPEN_STORE,new Operation(adminService.class, adminService::openStore));
        registerOperation(CLOSE_STORE,new Operation(managerService.class, managerService::closeStore));
        registerOperation(FORCE_CLOSE_STORE,new Operation(managerService.class, managerService::forceCloseStore));
  }
}

public class CustomerService {
    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void getCustomer(int id) {
        String customer = repository.findCustomerById(id);
        System.out.println("Customer found: " + customer);
    }
}

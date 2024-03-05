## Builder

```java
Copy code
// 产品类
class Computer {
    private String cpu;
    private String gpu;
    private int ram;
    private int storage;

    public Computer(String cpu, String gpu, int ram, int storage) {
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.storage = storage;
    }

    // Getters and setters...
}

// 构建器接口
interface ComputerBuilder {
    ComputerBuilder setCpu(String cpu);
    ComputerBuilder setGpu(String gpu);
    ComputerBuilder setRam(int ram);
    ComputerBuilder setStorage(int storage);
    Computer build();
}

// 具体构建器实现类
class DesktopBuilder implements ComputerBuilder {
    private String cpu;
    private String gpu;
    private int ram;
    private int storage;

    @Override
    public ComputerBuilder setCpu(String cpu) {
        this.cpu = cpu;
        return this;
    }

    @Override
    public ComputerBuilder setGpu(String gpu) {
        this.gpu = gpu;
        return this;
    }

    @Override
    public ComputerBuilder setRam(int ram) {
        this.ram = ram;
        return this;
    }

    @Override
    public ComputerBuilder setStorage(int storage) {
        this.storage = storage;
        return this;
    }

    @Override
    public Computer build() {
        return new Computer(cpu, gpu, ram, storage);
    }
}

// 客户端代码
public class Main {
    public static void main(String[] args) {
        ComputerBuilder builder = new DesktopBuilder();
        Computer computer = builder
            .setCpu("Intel Core i7")
            .setGpu("NVIDIA GeForce RTX 3080")
            .setRam(32)
            .setStorage(1000)
            .build();

        System.out.println("Computer details:");
        System.out.println("CPU: " + computer.getCpu());
        System.out.println("GPU: " + computer.getGpu());
        System.out.println("RAM: " + computer.getRam() + "GB");
        System.out.println("Storage: " + computer.getStorage() + "GB SSD");
    }
}
```

在这个示例中，我们有一个 `Computer` 类表示要构建的产品。然后我们定义了一个 `ComputerBuilder` 接口来规范构建器的方法，包括设置 CPU、GPU、RAM 和存储器等属性，并最终构建 `Computer` 对象的方法。

`DesktopBuilder` 类是具体的构建器实现，它实现了 `ComputerBuilder` 接口，并在每个方法中设置相应的属性。`build()` 方法负责构建最终的 `Computer` 对象。

在客户端代码中，我们实例化了一个 `DesktopBuilder` 对象，并使用一系列方法来设置电脑的属性，最后调用 `build()` 方法来获取构建好的 `Computer` 对象。

Builder 模式的核心是将构建复杂对象的过程分解成一系列简单的步骤，并将这些步骤封装在一个独立的构建器对象中。这种方式可以使得构建过程更加灵活，可以根据需要动态地调整构建步骤或组合不同的构建器来构建不同的对象。Builder 模式还可以隐藏产品的内部结构，使得客户端不需要关心对象是如何构建的，只需要通过构建器来指导构建过程。

**Tips: Builder模式，是用来（动态地）替代的构造方法。 通过一个interface里面包含了所有的setter()以及返回值为生产对象的build()方法.**

```java
// 构建器接口
interface ComputerBuilder {
    ComputerBuilder setCpu(String cpu);
    ComputerBuilder setGpu(String gpu);
    ComputerBuilder setRam(int ram);
    ComputerBuilder setStorage(int storage);
    Computer build();
}
```



## Provider / Manager


"Provider/Manager" 并不是一种特定的设计模式，而更像是一种通用的命名约定或模式。它常常用于表示某个组件或类负责提供特定功能或服务（Provider），而另一个组件或类负责管理这些提供的功能或服务（Manager）。

在软件开发中，"Provider/Manager" 经常用于描述不同的角色和责任。例如：

- **ConfigurationManager**: 负责管理应用程序的配置信息，可能提供加载、解析和存储配置的功能。

- **AuthenticationProvider**: 负责提供身份验证服务，验证用户的凭据并返回身份信息。

- **CacheManager**: 负责管理应用程序中的缓存，提供缓存数据的存储、获取、删除等操作。

- **EntityManager**: 在 JPA (Java Persistence API) 中，负责管理实体对象的生命周期和持久化，提供实体的持久化、检索、更新和删除等操作。

尽管 "Provider/Manager" 不是一个独立的设计模式，但它可以在不同的上下文中应用，用于描述类或组件之间的关系和责任分配。通常，"Provider" 负责提供一些特定的功能或服务，而 "Manager" 则负责管理这些功能或服务的使用、配置或生命周期。

```java
while (remaining > element.size()) {
	// 获取结果,加到result
  for (Integer ele : elements) result.add(ele);
  // 刷新到下一页
	remaining -= element.size();
	elements = client.fetchPage(nextPage++);
}
// 剩下的处理
for (int i = 0; i < remaining; i++) {
  result.add(elements.get(i));
} 

```


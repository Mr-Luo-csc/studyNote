# springCode spring框架案例 模拟

**给mapper的接口上加上@Repository，无法生成相应的bean,从而无法@Autowired，这是因为spring扫描注解时，自动过滤掉了接口和抽象类，这种情况下可以在启动的类前加上@MapperScan(从而使mapper可以自动注入，但是idea还会提示bean无法找到，但是不会影响运行)**
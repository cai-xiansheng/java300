package gof23.bridge;

/**
 * @author 张辉
 * @Description 未使用桥接模式
 * @create 2020-07-27 16:35
 */
public interface Computer {
    void sale();
}

class Desktop implements Computer {
    @Override
    public void sale() {
        System.out.println("Desktop.sale");
    }
}

class Laptop implements Computer {
    @Override
    public void sale() {
        System.out.println("Laptop.sale");
    }
}

class Pad implements Computer {
    @Override
    public void sale() {
        System.out.println("Pad.sale");
    }
}

class LenovoDesktop extends Desktop {
    @Override
    public void sale() {
        System.out.println("LenovoDesktop.sale");
    }
}

class LenovoLaptop extends Laptop {
    @Override
    public void sale() {
        System.out.println("LenovoLaptop.sale");
    }
}

class LenovoPad extends Pad {
    @Override
    public void sale() {
        System.out.println("LenovoLaptop.sale");
    }
}

class ShenzhouDesktop extends Desktop {
    @Override
    public void sale() {
        System.out.println("ShenzhouDesktop.sale");
    }
}

class ShenzhouLaptop extends Laptop {
    @Override
    public void sale() {
        System.out.println("ShenzhouLaptop.sale");
    }
}

class ShenzhouPad extends Pad {
    @Override
    public void sale() {
        System.out.println("ShenzhouLaptop.sale");
    }
}

class DellDesktop extends Desktop {
    @Override
    public void sale() {
        System.out.println("DellDesktop.sale");
    }
}

class DellLaptop extends Laptop {
    @Override
    public void sale() {
        System.out.println("DellLaptop.sale");
    }
}

class DellPad extends Pad {
    @Override
    public void sale() {
        System.out.println("DellLaptop.sale");
    }
}
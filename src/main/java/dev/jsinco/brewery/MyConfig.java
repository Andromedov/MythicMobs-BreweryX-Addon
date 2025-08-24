package dev.jsinco.brewery;

import com.dre.brewery.api.addons.AddonConfigFile;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyConfig extends AddonConfigFile {

    // OR You can use com.dre.brewery.depend.okaeri.configs.annotation.Exclude annotation
    private transient boolean someFieldWhichShouldBeIgnored = true;


    private String myString = "Hello, World!";
}

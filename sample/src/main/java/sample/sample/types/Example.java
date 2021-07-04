package sample.sample.types;

import com.manywho.sdk.entities.draw.elements.type.*;
import com.manywho.sdk.enums.ContentType;
import com.manywho.sdk.services.describe.types.AbstractType;

public class Example extends AbstractType {
    public static final String NAME = "Example";

    @Override
    public String getDeveloperName() {
        return NAME;
    }

    @Override
    public TypeElementBindingCollection getBindings() {
        return new TypeElementBindingCollection() {{
            add(new TypeElementBinding("Example", "An sample service Type", getDeveloperName(), new TypeElementPropertyBindingCollection() {{
                add(new TypeElementPropertyBinding("ID", "ID"));
                add(new TypeElementPropertyBinding("Name", "Name"));
                add(new TypeElementPropertyBinding("Description", "Description"));
            }}));
        }};
    }

    @Override
    public TypeElementPropertyCollection getProperties() {
        return new TypeElementPropertyCollection() {{
            add(new TypeElementProperty("ID", ContentType.String));
            add(new TypeElementProperty("Name", ContentType.String));
            add(new TypeElementProperty("Description", ContentType.String));
        }};
    }
}

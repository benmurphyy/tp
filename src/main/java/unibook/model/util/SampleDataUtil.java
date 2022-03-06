package unibook.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import unibook.model.ReadOnlyUniBook;
import unibook.model.UniBook;
import unibook.model.module.Module;
import unibook.model.module.ModuleCode;
import unibook.model.module.ModuleName;
import unibook.model.person.Email;
import unibook.model.person.Name;
import unibook.model.person.Person;
import unibook.model.person.Phone;
import unibook.model.tag.Tag;

/**
 * Contains utility methods for populating {@code UniBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                getTagSet("friends"), getModuleSet("CS2103")),
            new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                getTagSet("colleagues", "friends"), getModuleSet("CS2103")),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                getTagSet("neighbours"), getModuleSet("CS2103")),
            new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                getTagSet("family"), getModuleSet("CS2103")),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                getTagSet("classmates"), getModuleSet("CS2103")),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                getTagSet("colleagues"), getModuleSet("CS2103"))
        };
    }

    public static ReadOnlyUniBook getSampleUniBook() {
        UniBook sampleAb = new UniBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
            .map(Tag::new)
            .collect(Collectors.toSet());
    }

    /**
     * Returns a set of Module objects that have the given moduleCodes.
     *
     * @param moduleCodes module codes of the module objects
     * @return set of Module objects
     */
    public static Set<Module> getModuleSet(String... moduleCodes) {
        return Arrays.stream(moduleCodes)
            .map(moduleCode -> new Module(new ModuleName("placeholder module"), new ModuleCode(moduleCode)))
            .collect(Collectors.toSet());
    }

}

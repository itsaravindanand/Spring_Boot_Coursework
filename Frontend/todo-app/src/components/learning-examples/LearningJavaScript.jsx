// Define an object 'person' with various properties
const person = {
    // 'name' is a string property that stores the name of the person
    name: 'Aravind',

    // 'address' is an object property that stores the address details
    address: {
        // 'line1' represents the first line of the address
        line1: '221 Baker Street',
        // 'city' represents the city of the address
        city: 'London',
        // 'country' represents the country of the address
        country: 'UK',
    },

    // 'profiles' is an array property that stores the person's social media profiles
    profiles: ['twitter', 'linkedin', 'instagram'],

    // 'printProfile' is a method that prints each profile in the 'profiles' array to the console
    //  Similar to writing lambda functions in Java
    printProfile: () => {
        // Iterate over each profile in the 'profiles' array
        person.profiles.map(
            // Log each profile to the console
            profile => console.log(profile)
        );
    }
}


// Define a functional component named 'LearningJavaScript' and export it as the default export
export default function LearningJavaScript() {
    // Return a fragment containing multiple 'div' elements
    return (
        <>
            {/* Display the 'name' property of the 'person' object */}
            <div>{person.name}</div>

            {/* Display the 'line1' property of the 'address' object within the 'person' object */}
            <div>{person.address.line1}</div>

            {/* Display the first profile (index 0) from the 'profiles' array in the 'person' object */}
            <div>{person.profiles[0]}</div>

            {/* Call the 'printProfile' method of the 'person' object and display its return value */}
            <div>{person.printProfile()}</div>
        </>
    )
}

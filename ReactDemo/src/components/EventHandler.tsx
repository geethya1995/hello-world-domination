import { MouseEvent, useState } from "react";

function EventHandler() {
  let cities = ["Colombo", "London", "Melbourne", "Paris"];

  /* Dynamically highlighting an item once clicked on it using state hook
     selectedIndex is the var name and setSelectedIndex is the func that updates that var dynamicaaly

     Each component has its own state. If we have 2 EventHandler components inside the App file, those 2 lists will have their own states
  */
  //   let selectedIndex = 2;
  const [selectedIndex, setSelectedIndex] = useState(-1);

  // Event handling function
  const handleClick = (event: MouseEvent) => {
    console.log(event);
  };

  // list-group-item and active are classes
  // active --> to highligh an item
  // list-group-item --> to list nicely as a table sorta way
  return (
    <>
      <h1>Main List</h1>
      <ul className="list-group">
        {cities.map((city, index) => (
          <li
            className={
              selectedIndex === index
                ? "list-group-item active"
                : "list-group-item"
            }
            key={city}
            onClick={() => setSelectedIndex(index)}
            /* Handling the click event using a function
                onClick={handleClick}
            */
            /* After a click event, this is logged into console
                onClick={() =>
                    console.log(
                        "Clicked on a city " + city + " with the index " + index
                    )
            }
            */
          >
            {city}
          </li>
        ))}
      </ul>
    </>
  );
}

export default EventHandler;

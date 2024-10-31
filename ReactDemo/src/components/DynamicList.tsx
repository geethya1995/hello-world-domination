import { useState } from "react";

// PASSING DATA VIA PROPS || PASSING FUNC VIA PROPS
// Need to pass an obj with 2 elements into the JSX (an items:string[] and heading:string) since our FE is a list of elements with a heading
// Gives the blueprint of an obj
interface DynamicListProps {
  items: string[];
  heading: string;
  onSelectItem: (item: string) => void;
}

function DynamicList(props: DynamicListProps) {
  const [selectedIndex, setSelectedIndex] = useState(-1);

  return (
    <>
      <h1>{props.heading}</h1>
      {props.items.length === 0 && <p>No items found!</p>}
      <ul className="list-group">
        {props.items.map((item, index) => (
          <li
            className={
              selectedIndex === index
                ? "list-group-item active"
                : "list-group-item"
            }
            key={item}
            onClick={() => {
              setSelectedIndex(index);
              props.onSelectItem(item);
            }}
          >
            {item}
          </li>
        ))}
      </ul>
    </>
  );
}

export default DynamicList;

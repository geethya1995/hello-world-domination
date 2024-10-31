function ListGroup() {
  // Passing dynamic data into a list
  let cities = ["Colombo", "London", "Melbourne", "Paris"];
  //   cities = [];

  // conditional formatting
  if (cities.length === 0)
    return (
      <>
        <h1>List</h1>
        <p>No items found!</p>
      </>
    );

  // conditional formatting without an if statement outside the return (Instead writing that logic inside JSX)
  let fruits = ["Apple", "Banana", "Plum"];
  //   fruits = [];

  return (
    // React an render only 1 element per component. To add more than 1 elements, 2 mothods:
    // 1. Wrapping them using <div> element
    /*
    <div>
        <h1>List</h1>
        <ul className="list-group">
            <li className="list-group-item">An item</li>
            <li className="list-group-item">A second item</li>
            <li className="list-group-item">A third item</li>
            <li className="list-group-item">A fourth item</li>
            <li className="list-group-item">And a fifth one</li>
        </ul>
    </div>
    */

    // 2. Use fragments
    <>
      <h1>List</h1>
      <ul className="list-group">
        <li className="list-group-item">An item</li>
        <li className="list-group-item">A second item</li>
        {cities.map((city) => (
          <li className="list-group-item" key={city}>
            {city}
          </li>
        ))}

        {/* {fruits.length === 0 ? <p>No Fruit items found</p> : null} */}
        {fruits.length === 0 && <p>No Fruit items found</p>}
        {fruits.map((fruit) => (
          <li className="list-group-item" key={fruit}>
            {fruit}
          </li>
        ))}
      </ul>
    </>
  );
}

export default ListGroup;

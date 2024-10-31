// import Message from "./Message";
// import ListGroup from "./components/ListGroup";
// import EventHandler from "./components/EventHandler";
// import DynamicList from "./components/DynamicList";
import Alert from "./components/Alert";
import Buttons from "./components/Buttons";

function App() {
  // return <div><Message></Message></div>;
  // return <div><Message /></div>;

  /* ----- Passing data via props and functions -----
  const cities = ["London", "Melb", "Colombo"];
  const heading = "Cities";

  const handleSelectItem = (item: string) => {
    console.log(item);
  };

  return (
    <div>
      <DynamicList
        items={cities}
        heading={heading}
        onSelectItem={handleSelectItem}
      />
    </div>
  );
  */

  // alert-primary --> blue coloured alert
  return (
    <div>
      {/*<Alert text="Hello World"/>*/}
      {/*<Alert>Hello World</Alert>*/}
      {/* <Alert>
        <h1>Hello World</h1>
        <p>My first react app..</p>
      </Alert> */}
      <Buttons
        onClick={() => console.log("The buttons is clicked..")}
        colour="success"
      >
        My Button
      </Buttons>
    </div>
  );
}

export default App;

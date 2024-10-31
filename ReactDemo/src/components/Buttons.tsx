// Making the button component dynamic
interface ButtonProps {
  children: string;
  colour: string;
  // colour?: 'primary' | 'secondary'; // we can only set these 2 colours and they are alrady set by default. No need to pass as variabls
  onClick: () => void;
}

const Buttons = ({ children, colour, onClick }: ButtonProps) => {
  return (
    <div>
      <button type="button" className={"btn btn-" + colour} onClick={onClick}>
        {children}
      </button>
    </div>
  );
};

export default Buttons;

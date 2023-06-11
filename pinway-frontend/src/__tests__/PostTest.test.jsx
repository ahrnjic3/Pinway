import { render, screen } from '@testing-library/react';
import PostDetails from '../components/Posts/PostDetails';
import axios from "axios";
describe('Home', function () {

    it('Test renders correctly', async function () {
        render(<PostDetails/>);
        expect(screen.getByPlaceholderText(/Not selected/i)).toHaveTextContent("Not selected");
    });

    it('Test 1', async function () {
        render(<PostDetails/>);
        expect(screen.getByText(/Pin/i)).toBeInTheDocument();
        // expect(() => screen.getByRole('hello-button')).toThrow();
    });

    it('Test 2', async function () {
        render(<PostDetails/>);
        await userEvent.click(screen.getByText(/Pin/i));
        expect(screen.getByText(/Please select the connection you wish to pin the post to!/i)).toBeInTheDocument()
        // expect(() => screen.getByRole('hello-button')).toThrow();
    });

});
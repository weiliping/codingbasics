import os
import shutil


def move_files_to_parent(parent_folder):
    """
    Move all files from sub-folders to the parent folder.
    
    Args:
        parent_folder (str): Path to the parent folder
    """
    # Verify the parent folder exists
    if not os.path.isdir(parent_folder):
        print(f"Error: {parent_folder} is not a valid directory")
        return
    for sub in os.listdir(parent_folder):
        if len(sub) > 0 and sub[0] == '.':
            continue
        
        sub_path = os.path.join(parent_folder, sub)
        
        # Walk through all sub-folders
        for foldername, subfolders, filenames in os.walk(sub_path):
            # Skip the parent folder itself
            if foldername == sub_path:
                continue

            # Move each file to the parent folder
            for filename in filenames:
                file_path = os.path.join(foldername, filename)
                destination = os.path.join(sub_path, filename)
                
                # Handle filename conflicts
                counter = 1
                while os.path.exists(destination):
                    name, ext = os.path.splitext(filename)
                    destination = os.path.join(sub_path, f"{name}_{counter}{ext}")
                    counter += 1
                
                # Move the file
                shutil.move(file_path, destination)
                print(f"Moved: {file_path} -> {destination}")
        
    print("All files have been moved to the parent folder.")


# Example usage
if __name__ == "__main__":
    parent_folder = input("Enter the path to the parent folder: ")
    move_files_to_parent(parent_folder)

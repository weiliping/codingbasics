import os
import shutil
import argparse
from datetime import datetime


def organize_files_by_creation_date(source_folder, dry_run=False):
    """
    Organize files into year/month folders based on creation date
    
    Args:
        source_folder (str): Path to folder containing files to organize
        dry_run (bool): If True, only show what would be done without making changes
    """
    # Verify source folder exists
    if not os.path.isdir(source_folder):
        print(f"Error: {source_folder} is not a valid directory")
        return
    
    # Process each file in the source folder
    for filename in os.listdir(source_folder):
        file_path = os.path.join(source_folder, filename)
        
        # Skip directories
        if os.path.isdir(file_path):
            continue
        
        # Get file creation time (works differently on different OS)
        if os.name == 'nt':  # Windows
            creation_time = os.path.getctime(file_path)
        else:  # Unix/Mac - using modification time as creation time isn't easily available
            creation_time = os.path.getmtime(file_path)
        
        # Convert timestamp to datetime
        file_date = datetime.fromtimestamp(creation_time)
        year = str(file_date.year)
        month = f"{file_date.month:02d}"  # Zero-padded month
        f_name = year + '_' + month
        # Create target folder path
        target_folder = os.path.join(source_folder, f_name)
        
        if not dry_run:
            # Create folders if they don't exist
            os.makedirs(target_folder, exist_ok=True)
        
        # Prepare target path
        target_path = os.path.join(target_folder, filename)
        
        # Handle filename conflicts
        counter = 1
        while os.path.exists(target_path):
            name, ext = os.path.splitext(filename)
            target_path = os.path.join(target_folder, f"{name}_{counter}{ext}")
            counter += 1
        
        if dry_run:
            print(f"[Dry Run] Would move: {filename} -> {target_path}")
        else:
            shutil.move(file_path, target_path)
            print(f"Moved: {filename} -> {target_path}")


if __name__ == "__main__":
    # Set up argument parser
    parser = argparse.ArgumentParser(description='Organize files by creation date into YYYY/MM folders')
    parser.add_argument('source_folder', help='Path to the folder to organize')
    parser.add_argument('--dry-run', action='store_true', help='Simulate operation without making changes')
    
    # Parse arguments
    args = parser.parse_args()
    
    # Run the organizer
    organize_files_by_creation_date(args.source_folder, args.dry_run)
    print("File organization complete!")
